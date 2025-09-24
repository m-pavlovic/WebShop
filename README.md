# WebShop Java Project

A Java-based web shop GUI application built with Maven, Java 21 LTS, and Swing, following the MVC architectural pattern.

## Prerequisites

- **Java 21 or higher** - This project is configured to compile and run with Java 21 LTS
- **Maven** - A local Maven installation is included in the project (`apache-maven-3.9.6/`)

## Project Structure

This project follows the **MVC (Model-View-Controller)** architectural pattern:

```
src/main/java/com/webshop/
├── Main.java                           # Application entry point
├── model/                             # Domain models (M in MVC)
│   ├── Product.java                   # Product entity
│   ├── Cart.java                      # Shopping cart
│   ├── CartItem.java                  # Cart item
│   └── Customer.java                  # Customer entity
├── view/                              # User interface (V in MVC)
│   ├── MainFrame.java                 # Main GUI window
│   ├── ToolBarPanel.java              # Navigation toolbar
│   ├── ToolBarListener.java           # Toolbar event interface
│   └── ToolBarEvent.java              # Toolbar event class
└── controller/                        # Business logic (C in MVC)
    └── MainController.java            # Main controller

src/test/java/                         # Test source code
├── com/example/AppTest.java           # Legacy test
└── com/webshop/controller/
    └── MainControllerTest.java        # MVC controller tests

Other files:
├── pom.xml                            # Maven project configuration
├── apache-maven-3.9.6/               # Local Maven installation
└── target/                            # Compiled classes and build artifacts
```

## Architecture

This application implements the **MVC (Model-View-Controller)** design pattern:

### **Model** (`com.webshop.model`)
- **Product**: Represents products in the store with properties like name, price, stock
- **Cart**: Manages shopping cart functionality
- **CartItem**: Represents individual items in the cart
- **Customer**: Represents customer information

### **View** (`com.webshop.view`)
- **MainFrame**: Main GUI window built with Swing
  - Product catalog table
  - Shopping cart display
  - Add/remove cart functionality
  - Checkout interface
- **ToolBarPanel**: Navigation toolbar with HOME, CART, PROFILE, CONTACT buttons
- **ToolBarListener**: Interface for handling toolbar events
- **ToolBarEvent**: Event class that encapsulates toolbar actions with type, source, and timestamp

### **Controller** (`com.webshop.controller`)
- **MainController**: Implements ToolBarListener and handles navigation
  - Updates model based on user actions
  - Refreshes view when data changes
  - Manages sample product data

## Event-Driven Toolbar System

The application uses a modern event-driven approach for toolbar navigation:

- **ToolBarEvent**: Encapsulates toolbar actions with ActionType enum (HOME, CART, PROFILE, CONTACT)
- **ToolBarListener**: Interface with `onToolBarAction(ToolBarEvent event)` method
- **Event Flow**: ToolBarPanel → ToolBarEvent → MainController → Business Logic

## Java Version

This project has been upgraded to use **Java 21 LTS** with the following configuration:
- Maven Compiler Plugin 3.11.0
- Source and target compatibility: Java 21
- Uses `<release>21</release>` for optimal Java 21 module system compatibility

## Build Commands

### Using Local Maven (Recommended)

**Clean and compile:**
```bash
.\apache-maven-3.9.6\bin\mvn clean compile
```

**Full build with packaging:**
```bash
.\apache-maven-3.9.6\bin\mvn clean package
```

**Run tests:**
```bash
.\apache-maven-3.9.6\bin\mvn test
```

**Clean, test, and package:**
```bash
.\apache-maven-3.9.6\bin\mvn clean test package
```

### Using System Maven (if installed)

If you have Maven installed globally, you can use:
```bash
mvn clean compile
mvn clean package
mvn test
```

## Running the Application

**Execute the MVC application:**
```bash
.\apache-maven-3.9.6\bin\mvn exec:java "-Dexec.mainClass=com.webshop.Main"
```

**Alternative - run compiled class directly:**
```bash
java -cp target/classes com.webshop.Main
```

## Development

### IDE Setup
- Ensure your IDE is configured to use Java 21
- Import as a Maven project
- The project uses UTF-8 encoding

### Adding Dependencies
Add new dependencies to the `<dependencies>` section in `pom.xml` and run:
```bash
.\apache-maven-3.9.6\bin\mvn clean compile
```

## Troubleshooting

**Java Version Issues:**
- Ensure `JAVA_HOME` points to Java 21 or higher
- Check version with: `java -version`

**Build Issues:**
- Clean and rebuild: `.\apache-maven-3.9.6\bin\mvn clean compile`
- Check for compilation errors in the output

**Maven Issues:**
- The project includes a local Maven installation in `apache-maven-3.9.6/`
- Use the full path to the local Maven binary as shown in examples above
