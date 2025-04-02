🏨 Hostel Management 🏨
👋 Welcome 👋

Install and run
Required
Open source code with IntelliJ IDE
Installed JDK verison 11.x or above
Installed Tomcat server version 8.5.x or higher and below version 10
Installed Microsoft SQL Server Management Studio 18 and run the attached project script file in the source code folder
Installed NodeJS Latest Version and SASS
Install
Clone the source code to your computer and open the source code with IntelliJ IDE
Wait for the libraries configured in the dependencies of the POM.xml file to be downloaded
Select Runs/Debug configuration
Select Add New Configuration
Select Tomcat Server Local version
In the Server tab, in the Application server section, link to the folder where Tomcat is installed
In the Server tab, in the JRE section, link to the folder where the JDK is installed
On the Deployment tab, click Add, select Artifact and select HappyHostel:war
Also in the Deployment tab, scroll down to see the Application context item is currently "/HappyHostel_war", delete "_war" and click Apply
In the project's IntelliJ window, open Terminal with Command Prompt
Run command sass --watch src/main/webapp/assets/scss:src/main/webapp/assets/css to build SCSS files into CSS files to display styles for pages
Run
Click run to let IntelliJ turn on tomcat, build the project into a .war file and deploy it to the server
The web will automatically be turned on in the selected default browser or type "http://localhost:8080/HappyHostel/"


Technology
1. Frontend
HTML, CSS, Javascript, Bootstrap, jQuery
Font awesome
JSP - JavaServer Pages
JSTL - JSP Standard Tag Library
axios - Promise based HTTP client for the browser and node.js
...

2. Backend
Servlets - a Java programming language class that is used to extend the capabilities of servers that host applications accessed by means of a request-response programming model
JDBC - Java Database Connectivity - a Java API to connect and execute the query with the database

3. Database
Microsoft SQL Server - a relational model database server produced by Microsoft

4. Other Technologies
Design pattern: MVC2

5. Tool
IntelliJ
Java JDK 8
Apache Tomcat 8.5.29
Visual Studio Code
Microsoft SQL Server Management Studio 18

6.Libraries
Lombok
JSTL
sqljdbc4
Functional requirements
1. Guest:
 View home page
 Login by account
 Register a hostel owner account
 Register a renter account by invite code

2. Hostel Owner
 View home page
 Login by account
 Logout
 View account information
 Update account information
 List hostel
 Add new hostel
 Update hostel information
 View list services (Hostel detail)
 Add new service (Hostel detail)
 Room detail
 Add room
 Generate room account
 View Invite code
 Update room information (room detail)
 View room information
 Update room consume (room detail)
 View current consume (room detail)
 View history update consume (room detail)
 View room infrastructure (Room detail)
 Add room infrastructure (Room detail)
 Update infrastructure (Room detail)
 Update contact (room detail)
 View contract
 Generate contract (in generate room account screen)
 View detail invoice
 View all invoice
 Calculate money
 Export invoice
 View revenue statistic
 View report statistic
 View list roommates
 Add roommate
 Roommate information
 Update roommate information
 Send reports
 List report
 Process the report and change its state
 View list notification
 View detail notification
 Add notification

3. Hostel Owner
 View home page
 Login by account
 Logout
 View account information
 Update account information
 Hostel detail
 View list services (Hostel detail)
 Room detail
 View room information
 View room infrastructure (Room detail)
 View contract
 View detail invoice
 View all invoice
 Export invoice
 View list roommates
 Add roommate
 Roommate information
 Update roommate information
 Send reports
 List report
 View list notification

4. Admin:
 View home page
 Login by account
 Logout
 Managing account
 View list account pending to approve
