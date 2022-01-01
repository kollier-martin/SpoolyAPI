# Spooly API

### Features
- [ ] As a user, I can request a part by manufacturer
- [ ] As a user, I can request a custom car to be built

## Technologies Used
* Java 8 
* JavaScript ES6
* HTML5 & CSS3
* Bootstrap v5.1.3
* Apache Maven for dependencies management
* GitHub for version control
* MariaDB for database queries
* AWS EC2, ElasticBeanstalk, S3, CodeBuild, CodePipeline
* Spring Boot w/ Spring Data, Web, and Cloud

## Getting Started

#### Clone the repo
> git clone https://github.com/kollier-martin/SpoolyAPI
> 
> After cloning this is how your hierarchy should look.

![Post Cloning]()

#### Environment Set up Steps
1. Open project in a Java IDE, preferrably IntelliJ
2. The setup files for each service is already set up in the 'application.yml' files
3. To run application locally with confidential information set up 'application.propeties' file in each service to contain database and server information
  ```properties
  # Spring Data Source Information
  spring.datasource.url=
  spring.datasource.driverClassName=
  spring.datasource.username=
  spring.datasource.password=

  # Spring JPA & Hibernate
  spring.jpa.database-platform=
  spring.jpa.show-sql=true
  spring.jpa.generate-ddl=true
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.format_sql=true
  spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
  spring.jackson.serialization.fail-on-empty-beans=false

  # Logging
  logging.level.org.hibernate.stat=debug
  logging.level.org.hibernate.type=trace
```
## Usage
Here is an in-depth [guide]() for proper usage.

## Disclosure
This main [branch](kollier-martin/SpoolyAPI/master) contains the current release version of the project. <br />
The production [branch](kollier-martin/SpoolyAPI/production) contains the in-production version of the project. <br />

## Contributors

> Kollier Martin

## License

This project uses the following license: [GNU General Public License v3.0](LICENSE).
