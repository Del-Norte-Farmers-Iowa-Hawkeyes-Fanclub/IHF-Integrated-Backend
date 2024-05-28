package com.nighthawk.spring_portfolio.mvc.person;

import static jakarta.persistence.FetchType.EAGER;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nighthawk.spring_portfolio.mvc.player.Player;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Convert(attributeName = "person", converter = JsonType.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    @Email
    private String email;

    @NotEmpty
    private String password;

    private Integer eco;

    @NotEmpty
    private String primaryCrop;

    private Integer cash;

    private Integer cropQuantity;

    private double fantasyScore;

    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @ManyToMany(fetch = EAGER)
    private Collection<PersonRole> roles = new ArrayList<>();

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Map<String, Object>> stats = new HashMap<>();

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Integer> integerMap = new HashMap<>();

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private MapData mapData = new MapData();

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<Player>();

    public Person(String email, String password, String name, Integer eco, String primaryCrop, Integer cash, Date dob) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.eco = eco;
        this.primaryCrop = primaryCrop;
        this.cash = cash;
        this.cropQuantity = 0;
        this.dob = dob;
    }

    public Person(String email, String password, String name, Date dob) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.cash = 0;
        this.eco = 0;
        this.cropQuantity = 0;
        this.primaryCrop = "corn";
    }

    public String getPlayersJson() {
        try {
            List<Map<String, Object>> playerList = new ArrayList<>();
            for (Player player : this.players) {
                Map<String, Object> playerMap = new HashMap<>();
                playerMap.put("id", player.getId());
                playerMap.put("name", player.getPlayerName());
                playerMap.put("position", player.getPosition());
                playerList.add(playerMap);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(playerList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting players to JSON";
        }
    }


    public int getAge() {
        if (this.dob != null) {
            LocalDate birthDay = this.dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(birthDay, LocalDate.now()).getYears();
        }
        return -1;
    }

    public static void quickSort(Person[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Person[] arr, int low, int high) {
        Person pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is greater than or equal to the pivot
            if (arr[j].getCash() >= pivot.getCash()) {
                i++;

                // Swap arr[i] and arr[j]
                Person temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        Person temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void insertionSort(Person[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Person key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j].getEco() < key.getEco()) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(Person[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            // Split left part
            Person[] left = new Person[mid];
            System.arraycopy(arr, 0, left, 0, mid);

            // Split right part
            Person[] right = new Person[arr.length - mid];
            System.arraycopy(arr, mid, right, 0, arr.length - mid);

            mergeSort(left);
            mergeSort(right);

            // Merge left and right arrays
            merge(arr, left, right);
        }
    }

    private static void merge(Person[] result, Person[] left, Person[] right) {
        int i = 0, j = 0, k = 0;

        // Merge arrays into result in descending order based on cropQuantity
        while (i < left.length && j < right.length) {
            if (left[i].getCropQuantity() >= right[j].getCropQuantity()) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements of left, if any
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copy remaining elements of right, if any
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public static Person[] init() {
        Person p1 = new Person();
        p1.setName("h4seebcmd");
        p1.setEmail("mirzahbeg123@gmail.com");
        p1.setPassword("notTellingYouLOL");
        p1.setEco(-5);
        p1.setCropQuantity(0);
        p1.setPrimaryCrop("corn");
        p1.setCash(52);
        p1.setFantasyScore(100);
        p1.getIntegerMap().put("Team 1", 1);
        p1.getIntegerMap().put("Team 2", 40);
        List<Player> mockPlayers = new ArrayList<Player>();
        mockPlayers.add(new Player("jamal", "back", p1));
        p1.setPlayers(mockPlayers);
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("12-06-2007");
            p1.setDob(d);
        } catch (Exception e) {
        }

        Person p2 = new Person();
        p2.setName("tirthFarmer999");
        p2.setEmail("ermitsactuallypronouncedwithaTHUH@gmail.com");
        p2.setPassword("iLOVEagricutlre");
        p2.setEco(8);
        p2.setCash(14);
        p2.setCropQuantity(0);
        p2.setPrimaryCrop("corn");
        p2.getIntegerMap().put("Team 1", 1);
        p2.getIntegerMap().put("Team 2", 40);
        try {
            Date d2 = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-2024");
            p2.setDob(d2);
        } catch (Exception e) {
        }

        Person p3 = new Person();
        p3.setName("Thomas Edison");
        p3.setEmail("toby@gmail.com");
        p3.setPassword("123Toby!");
        p3.setCropQuantity(0);
        p3.setEco(0);
        p3.setCash(0);
        p3.setPrimaryCrop("corn");
        p3.getIntegerMap().put("Team 1", 1);
        p3.getIntegerMap().put("Team 2", 40);
        // adding Note to notes collection
        try { // All data that converts formats could fail
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1840");
            p3.setDob(d);
        } catch (Exception e) {
            // no actions as dob default is good enough
        }

        Person p4 = new Person();
        p4.setName("Tester Testing");
        p4.setEmail("test@gmail.com");
        p4.setPassword("password");
        p4.setEco(0);
        p4.setCash(0);
        p4.setCropQuantity(0);
        p4.setPrimaryCrop("corn");
        p4.getIntegerMap().put("Team 3", 2);
        p4.getIntegerMap().put("Team 4", 100);
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1845");
            p4.setDob(d);
        } catch (Exception e) {
        }

        Person p5 = new Person();
        p5.setName("Nikola Tesla");
        p5.setEmail("niko@gmail.com");
        p5.setPassword("123Niko!");
        p5.setPrimaryCrop("corn");
        p5.setEco(0);
        p5.setCash(0);
        p5.setCropQuantity(0);
        p5.getIntegerMap().put("Team 6", 60);
        p5.getIntegerMap().put("Team 5", 30);
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1850");
            p5.setDob(d);
        } catch (Exception e) {
        }

        Person p6 = new Person();
        p6.setName("Madam Currie");
        p6.setEmail("madam@gmail.com");
        p6.setPassword("123Madam!");
        p6.setPrimaryCrop("corn");
        p6.setEco(0);
        p6.setCash(0);
        p6.setCropQuantity(0);
        p6.getIntegerMap().put("Team 8", 120);
        p6.getIntegerMap().put("Team 9", 203);
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1860");
            p6.setDob(d);
        } catch (Exception e) {
        }

        Person p7 = new Person();
        p7.setName("John Mortensen");
        p7.setEmail("jm1021@gmail.com");
        p7.setPassword("123Qwerty!");
        p7.setPrimaryCrop("corn");
        p7.setEco(0);
        p7.setCash(0);
        p7.setCropQuantity(0);
        p7.getIntegerMap().put("Team 91", 808);
        p7.getIntegerMap().put("Easter Egg", 90210);
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("10-21-1959");
            p7.setDob(d);
        } catch (Exception e) {
        }

        Person persons[] = { p1, p2, p3, p4, p5, p6, p7 };
        return persons;
    }

    public static void initializeIntegerMaps(Person[] persons) {
        for (Person person : persons) {
            Map<String, Integer> integerMap = person.getIntegerMap();
            if (integerMap.isEmpty()) {
                integerMap.put("value1", 10);
                integerMap.put("value2", 20);
                integerMap.put("value3", 30);
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", players=" + players +
                '}';
    }

    public static void main(String[] args) {
        Person[] persons = init();
        initializeIntegerMaps(persons);
        for (Person person : persons) {
            System.out.println("Name: " + person.getName());
            System.out.println("Email: " + person.getEmail());
            System.out.println("Password: " + person.getPassword());
            System.out.println("Date of Birth: " + person.getDob());
            System.out.println("Age: " + person.getAge());
            System.out.println("Integer Map: " + person.getIntegerMap());
            System.out.println("---------------------------------");
        }
    }
}
