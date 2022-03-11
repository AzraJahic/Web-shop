# Web-shop
Full-stack project with Angular framework for Front-end, MySQL for database, and Java EE for business logic. Dynamic Web app where you can see all new items, items on sale, and other products directly imported from the database. Also, user can fulfill form and their data will be posted in the database. Get and post are possible thanks to RESTful API. 

## Database
For data we used MySQL Workbench, .sql file need to be full imported in MySQL Workbench 

- First of all we made new user hbstudent with password hbstudent, that makes possible connecting database and java classes with jdbc code
- To user are granted permissions for the same reason mentioned above
- Rest of .sql file is based on creating a schema and tables with needed data

This part is necessary to be done before everything else, so the app can work properly

## Servlets
Servlets necessary for communication between databse and front-end are made as one web dynamic project in "WebShopApp" folder. They are made in Eclipse IDE EE, and they are organised into packages.

- It's important to add Web Dynamic Project into your eclipse-workspace so that all servlets are working properly, this means that WebShopApp folder need to be on location ../eclipse-workspace/WebShopApp/..
- When everything is set up properly project will be hosted on TomCat server and will made IP localhost:8080

This part is necessary to be done before hosting front-end page so that Servlet can send necessary data to front-end page, and recieve (if any) data from front-end page.

## Web Page
Front-end for this project is made thanks to Angular framework and can be find in "track-and-trace-web-shop" folder.

- This part of project will be executed with ng serve command, and will be hosted on localhost:4200

### About project
This project was final exam of the course for Java Developer on eMPIRICA and it took 3 weeks to be done. 
