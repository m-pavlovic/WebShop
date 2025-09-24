# WebShop Java Project# WebShop Java Project# WebShop Java Project



A Java-based web shop GUI application built with Maven, Java 21 LTS, and Swing, following the MVC architectural pattern.



## PrerequisitesA simple Java project built with Maven and Java 21 LTS.A Java-based web shop GUI application built with Maven, Java 21 LTS, and Swing, following the MVC architectural pattern.



- **Java 21 or higher** - This project is configured to compile and run with Java 21 LTS

- **Maven** - A local Maven installation is included in the project (`apache-maven-3.9.6/`)

## Prerequisites## Prerequisites

## Project Structure



The project follows an MVC (Model-View-Controller) architectural pattern:

- **Java 21 or higher** - This project is configured to compile and run with Java 21 LTS- **Java 21 or higher** - This project is configured to compile and run with Java 21 LTS

```

src/main/java/com/webshop/- **Maven** - A local Maven installation is included in the project (`apache-maven-3.9.6/`)- **Maven** - A local Maven installation is included in the project (`apache-maven-3.9.6/`)

├── Main.java                       # Application entry point with Swing initialization

├── controller/                     # Business logic layer (empty, ready for development)

├── model/                          # Data models (empty, ready for development)  

└── view/                          # User interface layer## Project Structure## Project Structure

    └── MainFrame.java             # Main window class (skeleton created)



src/test/java/com/webshop/

└── AppTest.java                   # Basic unit test- `src/main/java/` - Main application source codeThis project follows the **MVC (Model-View-Controller)** architectural pattern:



Other files:- `src/test/java/` - Test source code  

├── pom.xml                        # Maven project configuration

├── apache-maven-3.9.6/           # Local Maven installation- `pom.xml` - Maven project configuration```

└── target/                        # Compiled classes and build artifacts

```- `apache-maven-3.9.6/` - Local Maven installationsrc/main/java/com/webshop/



### Current Development Status- `target/` - Compiled classes and build artifacts├── Main.java                           # Application entry point

- ✅ **Main.java**: Application entry point with SwingUtilities setup

- 🚧 **MainFrame.java**: UI main window class (empty skeleton ready for development)├── model/                             # Domain models (M in MVC)

- 📁 **MVC Directories**: Package structure created for controller, model, and view layers

- ✅ **Tests**: Basic test structure in place## Java Version│   ├── Product.java                   # Product entity



## Java Version│   ├── Cart.java                      # Shopping cart



This project has been upgraded to use **Java 21 LTS** with the following configuration:This project has been upgraded to use **Java 21 LTS** with the following configuration:│   ├── CartItem.java                  # Cart item

- Maven Compiler Plugin 3.11.0

- Source and target compatibility: Java 21- Maven Compiler Plugin 3.11.0│   └── Customer.java                  # Customer entity

- Uses `<release>21</release>` for optimal Java 21 module system compatibility

- Source and target compatibility: Java 21├── view/                              # User interface (V in MVC)

## Build Commands

- Uses `<release>21</release>` for optimal Java 21 module system compatibility│   └── MainFrame.java                 # Main GUI window

### Using Local Maven (Recommended)

└── controller/                        # Business logic (C in MVC)

**Clean and compile:**

```bash## Build Commands    └── WebShopController.java         # Main controller

.\apache-maven-3.9.6\bin\mvn clean compile

```



**Full build with packaging:**### Using Local Maven (Recommended)src/test/java/                         # Test source code

```bash

.\apache-maven-3.9.6\bin\mvn clean package├── com/example/AppTest.java           # Legacy test

```

**Clean and compile:**└── com/webshop/controller/

**Run tests:**

```bash```bash    └── WebShopControllerTest.java     # MVC controller tests

.\apache-maven-3.9.6\bin\mvn test

```.\apache-maven-3.9.6\bin\mvn clean compile



**Clean, test, and package:**```Other files:

```bash

.\apache-maven-3.9.6\bin\mvn clean test package├── pom.xml                            # Maven project configuration

```

**Full build with packaging:**├── apache-maven-3.9.6/               # Local Maven installation

### Using System Maven (if installed)

```bash└── target/                            # Compiled classes and build artifacts

If you have Maven installed globally, you can use:

```bash.\apache-maven-3.9.6\bin\mvn clean package```

mvn clean compile

mvn clean package```

mvn test

```## Architecture



## Running the Application**Run tests:**



**Execute the main class:**```bashThis application implements the **MVC (Model-View-Controller)** design pattern:

```bash

.\apache-maven-3.9.6\bin\mvn exec:java "-Dexec.mainClass=com.webshop.Main".\apache-maven-3.9.6\bin\mvn test

```

```### **Model** (`com.webshop.model`)

**Alternative - run compiled class directly:**

```bash- **Product**: Represents products in the store with properties like name, price, stock

java -cp target/classes com.webshop.Main

```**Clean, test, and package:**- **Cart**: Manages shopping cart functionality



## Development```bash- **CartItem**: Represents individual items in the cart



### MVC Architecture.\apache-maven-3.9.6\bin\mvn clean test package- **Customer**: Represents customer information

The project is set up for MVC development:

- **Model**: Add your data classes (Product, Cart, Customer, etc.) in `com.webshop.model````

- **View**: Add your UI components in `com.webshop.view` (MainFrame is started)

- **Controller**: Add your business logic classes in `com.webshop.controller`### **View** (`com.webshop.view`)



### IDE Setup### Using System Maven (if installed)- **MainFrame**: Main GUI window built with Swing

- Ensure your IDE is configured to use Java 21

- Import as a Maven project  - Product catalog table

- The project uses UTF-8 encoding

If you have Maven installed globally, you can use:  - Shopping cart display

### Adding Dependencies

Add new dependencies to the `<dependencies>` section in `pom.xml` and run:```bash  - Add/remove cart functionality

```bash

.\apache-maven-3.9.6\bin\mvn clean compilemvn clean compile  - Checkout interface

```

mvn clean package

## Known Issues

## Running the Application  - Updates model based on user actions

## Troubleshooting

  - Refreshes view when data changes

**Java Version Issues:**

- Ensure `JAVA_HOME` points to Java 21 or higher**Execute the main class:**  - Manages sample product data

- Check version with: `java -version`

```bash

**Build Issues:**

- Clean and rebuild: `.\apache-maven-3.9.6\bin\mvn clean compile`.\apache-maven-3.9.6\bin\mvn exec:java "-Dexec.mainClass=com.example.App"## Java Version

- Check for compilation errors in the output

```

**Maven Issues:**

- The project includes a local Maven installation in `apache-maven-3.9.6/`This project has been upgraded to use **Java 21 LTS** with the following configuration:

- Use the full path to the local Maven binary as shown in examples above
**Alternative - run compiled class directly:**- Maven Compiler Plugin 3.11.0

```bash- Source and target compatibility: Java 21

java -cp target/classes com.example.App- Uses `<release>21</release>` for optimal Java 21 module system compatibility

```

## Build Commands

## Development

### Using Local Maven (Recommended)

### IDE Setup

- Ensure your IDE is configured to use Java 21**Clean and compile:**

- Import as a Maven project```bash

- The project uses UTF-8 encoding.\apache-maven-3.9.6\bin\mvn clean compile

```

### Adding Dependencies

Add new dependencies to the `<dependencies>` section in `pom.xml` and run:**Full build with packaging:**

```bash```bash

.\apache-maven-3.9.6\bin\mvn clean compile.\apache-maven-3.9.6\bin\mvn clean package

``````



## Troubleshooting**Run tests:**

```bash

**Java Version Issues:**.\apache-maven-3.9.6\bin\mvn test

- Ensure `JAVA_HOME` points to Java 21 or higher```

- Check version with: `java -version`

**Clean, test, and package:**

**Build Issues:**```bash

- Clean and rebuild: `.\apache-maven-3.9.6\bin\mvn clean compile`.\apache-maven-3.9.6\bin\mvn clean test package

- Check for compilation errors in the output```



**Maven Issues:**### Using System Maven (if installed)

- The project includes a local Maven installation in `apache-maven-3.9.6/`

- Use the full path to the local Maven binary as shown in examples aboveIf you have Maven installed globally, you can use:
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
