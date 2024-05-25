import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

/* REPTITION OCCURS */

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}
import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class Option {
    private String symbol;
    private double strikePrice;
    private String expirationDate;
    private double price;

    public Option(String symbol, double strikePrice, String expirationDate, double price) {
        this.symbol = symbol;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    // Getters and setters omitted for brevity
}

class User {
    private String username;
    private List<Option> purchasedOptions;

    public User(String username) {
        this.username = username;
        this.purchasedOptions = new ArrayList<>();
    }

    public void buyOption(Option option) {
        this.purchasedOptions.add(option);
    }

    public List<Option> getPurchasedOptions() {
        return this.purchasedOptions;
    }
}

class OptionsMarketplace {
    private List<Option> availableOptions;

    public OptionsMarketplace() {
        this.availableOptions = new ArrayList<>();
    }

    public void addOption(Option option) {
        this.availableOptions.add(option);
    }

    public void tradeOption(User buyer, Option option) {
        if (availableOptions.contains(option)) {
            buyer.buyOption(option);
            availableOptions.remove(option);
        } else {
            System.out.println("Option not available.");
        }
    }

    public List<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

public class Main {
    public static void main(String[] args) {
        OptionsMarketplace marketplace = new OptionsMarketplace();

        Option option1 = new Option("AAPL", 150.0, "2024-06-21", 5.0);
        Option option2 = new Option("GOOGL", 2800.0, "2024-06-21", 20.0);

        marketplace.addOption(option1);
        marketplace.addOption(option2);

        User user = new User("akshat");

        marketplace.tradeOption(user, option1);

        System.out.println("User's purchased options:");
        for (Option option : user.getPurchasedOptions()) {
            System.out.println(option.getSymbol() + " - " + option.getStrikePrice());
        }
    }
}

/* REPTITION OCCURS */
