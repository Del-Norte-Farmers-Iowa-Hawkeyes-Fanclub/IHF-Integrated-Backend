package com.nighthawk.spring_portfolio.mvc.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.JsonObject;
import com.nighthawk.spring_portfolio.mvc.person.MapData.Layer;
import com.nighthawk.spring_portfolio.mvc.person.MapData.Tileset;
import com.nighthawk.spring_portfolio.mvc.player.*;

import java.util.*;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/person")
public class PersonApiController {
    // Autowired enables Control to connect POJO Object through JPA
    @Autowired
    private PersonJpaRepository repository;

    @Autowired
    private PlayerJpaRepository playerRepo;

    @Autowired
    private PersonDetailsService personDetailsService;

    /*
     * GET List of People
     */
    @GetMapping("/")
    public ResponseEntity<List<Person>> getPeople() {
        return new ResponseEntity<>(repository.findAllByOrderByNameAsc(), HttpStatus.OK);
    }

    /*
     * GET individual Person using ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            Person person = optional.get(); // value from findByID
            return new ResponseEntity<>(person, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/setPlayers")
    public ResponseEntity<Person> setPlayers(@RequestBody Map<String, String> requestBody) {
        Person person = repository.findByEmail((String) requestBody.get("email"));
        person.getPlayers().clear();  // Clear existing players

        
        requestBody.forEach((position, name) -> {
            if (position == "email") return;
            Player player = new Player(name, position, person);
            playerRepo.save(player);
            person.getPlayers().add(player);
        });

        repository.save(person);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/getPlayers")
    public ResponseEntity<List<Player>> getPlayers(@RequestBody Map<String, String> requestBody) {
        Person person = repository.findByEmail((String) requestBody.get("email"));

        return new ResponseEntity<>(person.getPlayers(), HttpStatus.OK);
    }

    @GetMapping("/getFantasyScore")
    public ResponseEntity<Object> getFantasyScore(@RequestParam String email) {
        try {
            Person person = repository.findByEmail(email);
            if (person == null) {
                return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(person.getFantasyScore(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/setFantasyScore/")
    public ResponseEntity<Object> setFantasyScore(@RequestBody Map<String, String> requestBody) {
        try {
            String email = requestBody.get("email");
            String scoreStr = requestBody.get("score");
            
            System.out.println("Email: " + email);  // Debugging statement
            System.out.println("Score: " + scoreStr);  // Debugging statement
            
            if (email == null || scoreStr == null) {
                return new ResponseEntity<>("Email and score are required", HttpStatus.BAD_REQUEST);
            }
            Person person = repository.findByEmail(email);
            if (person == null) {
                return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
            }
            double score = Double.parseDouble(scoreStr);
            person.setFantasyScore(score);
            repository.save(person);
            return new ResponseEntity<>(person.getFantasyScore(), HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid score format", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    /*
     * DELETE individual Person using ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable long id) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            Person person = optional.get(); // value from findByID
            repository.deleteById(id); // value from findByID
            return new ResponseEntity<>(person, HttpStatus.OK); // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
     * POST Aa record by Requesting Parameters from URI
     */
    @PostMapping("/post")
    public ResponseEntity<Object> postPerson(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");
        String name = (String) requestBody.get("name");
        String dobString = (String) requestBody.get("dob");

        Date dob;
        try {
            dob = new SimpleDateFormat("MM-dd-yyyy").parse(dobString);
        } catch (Exception e) {
            return new ResponseEntity<>(dobString + " error; try MM-dd-yyyy", HttpStatus.BAD_REQUEST);
        }

        // A person object WITHOUT ID will create a new record with default roles as
        // student
        Person person = new Person(email, password, name, dob);
        personDetailsService.save(person);

        return new ResponseEntity<>(email + " is created successfully", HttpStatus.CREATED);
    }

    /*
     * The personSearch API looks across database for partial match to term (k,v)
     * passed by RequestEntity body
     */
    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> personSearch(@RequestBody final Map<String, String> map) {
        // extract term from RequestEntity
        String term = (String) map.get("term");

        // JPA query to filter on term
        List<Person> list = repository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(term, term);

        // return resulting list and status, error checking should be added
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*
     * The personStats API adds stats by Date to Person table
     */
    @PostMapping(value = "/setStats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> personStats(@RequestBody final Map<String, Object> stat_map) {
        // find ID
        long id = Long.parseLong((String) stat_map.get("id"));
        Optional<Person> optional = repository.findById((id));
        if (optional.isPresent()) { // Good ID
            Person person = optional.get(); // value from findByID

            // Extract Attributes from JSON
            Map<String, Object> attributeMap = new HashMap<>();
            for (Map.Entry<String, Object> entry : stat_map.entrySet()) {
                // Add all attribute other than "date" to the "attribute_map"
                if (!entry.getKey().equals("date") && !entry.getKey().equals("id"))
                    attributeMap.put(entry.getKey(), entry.getValue());
            }

            // Set Date and Attributes to SQL HashMap
            Map<String, Map<String, Object>> date_map = new HashMap<>();
            date_map.put((String) stat_map.get("date"), attributeMap);
            person.setStats(date_map); // BUG, needs to be customized to replace if existing or append if new
            repository.save(person); // conclude by writing the stats updates

            // return Person with update Stats
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        // return Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
     * GET List of People sorted by eco score (highest to lowest)
     */
    @GetMapping("/eco")
    public ResponseEntity<List<Person>> getPeopleSortedByEco() {
        List<Person> people = repository.findAll();
        people.sort(Comparator.comparingInt(Person::getEco).reversed());
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/ecoAlt")
    public ResponseEntity<List<Person>> ecoAlt() {
        List<Person> people = repository.findAll();
        Person[] peopleArray = people.toArray(new Person[0]);
        Person.insertionSort(peopleArray);
        return new ResponseEntity<>(Arrays.asList(peopleArray), HttpStatus.OK);
    }

    @PostMapping("/getEco")
    public ResponseEntity<Object> getEco(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Person player = personDetailsService.getByEmail(email);
        int eco = (player != null) ? player.getEco() : 0;
        return new ResponseEntity<>(eco, HttpStatus.OK);
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Person>> getPeopleSortedByCrops() {
        List<Person> people = repository.findAll();
        people.sort(Comparator.comparingInt(Person::getCropQuantity).reversed());
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/cash")
    public ResponseEntity<List<Person>> getPeopleSortedByCash() {
        List<Person> people = repository.findAll();
        people.sort(Comparator.comparingInt(Person::getCash).reversed());
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/cashAlt")
    public ResponseEntity<List<Person>> cashSortAlternate() {
        List<Person> people = repository.findAll();
        Person[] peopleArray = people.toArray(new Person[0]);
        Person.quickSort(peopleArray, 0, peopleArray.length - 1);
        return new ResponseEntity<>(Arrays.asList(peopleArray), HttpStatus.OK);
    }

    @PostMapping("/getCrops")
    public ResponseEntity<Object> getCrops(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Person player = personDetailsService.getByEmail(email);
        int cropQuantity = (player != null) ? player.getCropQuantity() : 0;
        return new ResponseEntity<>(cropQuantity, HttpStatus.OK);
    }

    @PostMapping("/cropQuantityUpdate")
    public ResponseEntity<Object> postCropQuantity(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Integer cropQuantity = (Integer) requestBody.get("cropQuantity");

        personDetailsService.changeCropQuantity(email, cropQuantity);

        return new ResponseEntity<>(email + " is updated successfully", HttpStatus.CREATED);
    }

    @PostMapping("/ecoUpdate")
    public ResponseEntity<Object> postEco(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Integer eco = (Integer) requestBody.get("eco");

        personDetailsService.changeEco(email, eco);
        return new ResponseEntity<>(email + " is updated successfully", HttpStatus.CREATED);
    }

    @PostMapping("/getCash")
    public ResponseEntity<Object> getCash(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Person player = personDetailsService.getByEmail(email);
        System.out.println(player.getCash());
        int cash = (player != null) ? player.getCash() : 0;
        System.out.println(player.getCash());
        return new ResponseEntity<>(cash, HttpStatus.OK);
    }

    @PostMapping("/cashUpdate")
    public ResponseEntity<Object> postCash(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Integer cash = (Integer) requestBody.get("cash");

        personDetailsService.changeCash(email, cash);

        return new ResponseEntity<>(email + " is updated successfully", HttpStatus.CREATED);
    }

    @PostMapping("/integerMap/update/{id}")
    public ResponseEntity<String> updateIntegerMap(@PathVariable long id,
            @RequestBody Map<String, Integer> integerMap) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) {
            Person person = optional.get();
            Map<String, Integer> existingIntegerMap = person.getIntegerMap();
            existingIntegerMap.putAll(integerMap);
            person.setIntegerMap(existingIntegerMap);
            repository.save(person);
            return new ResponseEntity<>("Additional key-value pairs added to the integerMap for person with ID: " + id,
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Person not found with ID: " + id, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/integerMap/{id}")
    public ResponseEntity<Map<String, Integer>> getIntegerMap(@PathVariable long id) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) {
            Person person = optional.get();
            Map<String, Integer> integerMap = person.getIntegerMap();
            return new ResponseEntity<>(integerMap, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("integerMap/delete/{id}")
    public ResponseEntity<String> deleteIntegerMap(@PathVariable long id) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) {
            Person person = optional.get();
            person.setIntegerMap(new HashMap<>());
            repository.save(person);
            return new ResponseEntity<>("IntegerMap deleted successfully for person with ID: " + id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Person not found with ID: " + id, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/mapData/update/{email}")
    public ResponseEntity<String> updateMapData(@PathVariable String email,
            @RequestBody Map<String, Object> requestBody) {
        // Extract mapData from the requestBody
        Map<String, Object> mapDataMap = (Map<String, Object>) requestBody.get("mapData");

        // Extract layers
        List<Map<String, Object>> layersMapList = (List<Map<String, Object>>) mapDataMap.get("layers");
        List<Layer> layers = new ArrayList<>();
        for (Map<String, Object> layerMap : layersMapList) {
            // Ensure data is correctly casted to List<Integer>
            Object dataObj = layerMap.get("data");
            List<Integer> data = new ArrayList<>();
            if (dataObj instanceof List) {
                // Safe cast to List<Integer>
                List<?> dataList = (List<?>) dataObj;
                for (Object item : dataList) {
                    if (item instanceof Integer) {
                        data.add((Integer) item);
                    }
                }
            } else {
                // Handle the case where data is not a List<Integer> Will break rendering btw
                System.out.println("Warning: 'data' is not a List<Integer>.");
            }

            Layer layer = new Layer(data, (int) layerMap.get("height"), (int) layerMap.get("id"),
                    (String) layerMap.get("name"), (double) layerMap.get("opacity"), (String) layerMap.get("type"),
                    (boolean) layerMap.get("visible"), (int) layerMap.get("width"), (int) layerMap.get("x"),
                    (int) layerMap.get("y"));
            layers.add(layer);
        }

        // Extract tilesets
        List<Map<String, Object>> tilesetsMapList = (List<Map<String, Object>>) mapDataMap.get("tilesets");
        List<Tileset> tilesets = new ArrayList<>();
        for (Map<String, Object> tilesetMap : tilesetsMapList) {
            Tileset tileset = new Tileset((int) tilesetMap.get("columns"), (int) tilesetMap.get("firstgid"),
                    (String) tilesetMap.get("image"), (int) tilesetMap.get("imageheight"),
                    (int) tilesetMap.get("imagewidth"),
                    (int) tilesetMap.get("margin"), (String) tilesetMap.get("name"), (int) tilesetMap.get("spacing"),
                    (int) tilesetMap.get("tilecount"), (int) tilesetMap.get("tileheight"),
                    (int) tilesetMap.get("tilewidth"));
            tilesets.add(tileset);
        }

        // Create MapData object from mapDataMap
        MapData mapData = new MapData(
                (int) mapDataMap.get("compressionlevel"),
                (int) mapDataMap.get("height"),
                (boolean) mapDataMap.get("infinite"),
                layers,
                (int) mapDataMap.get("nextlayerid"),
                (int) mapDataMap.get("nextobjectid"),
                (String) mapDataMap.get("orientation"),
                (String) mapDataMap.get("renderorder"),
                (String) mapDataMap.get("tiledversion"),
                (int) mapDataMap.get("tileheight"),
                tilesets,
                (int) mapDataMap.get("tilewidth"),
                (String) mapDataMap.get("type"),
                (String) mapDataMap.get("version"),
                (int) mapDataMap.get("width"));

        // Call personDetailsService to set the mapData
        personDetailsService.setMapData(email, mapData);

        return new ResponseEntity<>("MapData updated successfully for person with email: " + email, HttpStatus.OK);
    }

    @GetMapping("/getMapData/{email}")
    public ResponseEntity<String> getMapData(@PathVariable String email) {
        System.out.println(email);
        MapData mapData = personDetailsService.getMapData(email);
        if (mapData != null) {
            System.out.println(mapData);
            return new ResponseEntity<>(mapData.toJson().toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
