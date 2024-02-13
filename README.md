# CRUD-in-Java
This project demonstrates a simple MySQL CRUD (Create, Read, Update, Delete) operation using Java programming language. The project is specifically geared towards beginner Java developers willing to learn and experiment with database operations.

## Setup
Follow the instructions below to get this project up and running on your local machine:

### Setup the database
1. Download and install XAMPP</br>
   </br>
2. Start Apache and MySQL modules</br>
   </br>
   ![how to start apache and mysql on xampp](images/Xampp-start.png)</br>
   </br>
3. Open the phpmyadmin interface, pressing config on MySQL method or searching [127.0.0.1/phpmyadmi](http://127.0.0.1/phpmyadmin) </br>
   </br>
4. Download the [SQL file](database/dbesempio.sql) and import it in the phpmyadmin interface</br>
   </br>

   ![press import on phpmyadmin](images/main-page-phpmyadmin.png)*Select Import on the interface*</br>
   </br>
   ![select the file to import](images/select-import-file.png)*Select the .sql file to import*</br>
   </br>
   ![press import on phpmyadmin](images/execute-import.png)*Execute the import*</br>
   </br>
![database is created](images/database-created.png)*Database is created*</br>
   </br>

## Setup the IDE

You have two choices here:

1. If you want a quick start, simply use `git clone` for this repository and press start. The required dependencies are included in the lib folder.
   </br>From here follow _[usage section](README.md#usage)_ 
2. If you'd like to write your code, you have to setup the IDE - this project was developed with IntelliJ</br>
   **Follow this steps only if you want to write your code from blank**

## Usage
After setting up the project and database, run the main Java file. You'll be presented with a textual menu in the console to perform CRUD operations.

## Contributing
Issues, PRs, and all your suggestions and discussions are very welcome!

## License
This project is licensed under the MIT License - see the LICENSE.md file for details