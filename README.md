<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->

[![Java][Java]][Java-url]
[![Spring-boot][Spring-boot]][Spring-boot-url]
[![Mongo-db][Mongo-db]][Mongo-db-url] 
[![Docker][Docker]][Docker-url]



<!-- PROJECT LOGO -->
<br />

[//]: # (<div align="center">)

[//]: # (  <a href="https://github.com/othneildrew/Best-README-Template">)

[//]: # (    <img src="images/logo.png" alt="Logo" width="80" height="80">)

[//]: # (  </a>)

<h3 align="center">Drone Management API Project</h3>

  <p align="center">
    A simple web API for a drone delivery service
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

This API provide endpoints for:
* Drones management
* Medications management
* Dispatch management

The project is an assessment solution for a drone service.

All API input/output data are in JSON format

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

The project is developed using the following technologiea.

* [![Java][Java]][Java-url]
* [![Spring-boot][Spring-boot]][Spring-boot-url]
* [![Mongo-db][Mongo-db]][Mongo-db-url]
* [![Docker][Docker]][Docker-url]

[//]: # (* [![Postman][Postman]][Postman-url])


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites
The project is developed with Java, hence the Java JDK should be installed on your machine. Also, Docker installation is required since the project uses a containerized MongoDB database. 


* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Clone the repo
   ```sh
   git clone https://github.com/dapperGeek/Spring-Boot-API-Drone-Service-.git
   ```
2. **Launch MongoDB Container** <br />Open CLI, navigate to the project directory and run MongoDB database container via docker compose. MongoDB container configuration are in the docker-compose.yaml file
   ```sh
   docker compose up -d
   ```
   Once Docker container is started, Mongo Express GUI can be assessed on localhost port 8081 via the Uri <a href="http://localhost:8081/db/drones">http://localhost:8081/db/drones
   
3. Project is built using IntelliJ IDEA, running the application can be done via the IDE run feature. <br />Alternatively, the application can be run via the CLI ...
    
    On successful run operation, project uri is accessible on localhost via <a>http://localhost:8080/api/v1/drones

4. 


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

All HTTP Request tests are done using PostMan. POST & PUT request are implemented by sending JSON formatted requests to the API endpoints.

### Registering A Drone
#### API Endpoint: http://localhost:8080/api/v1/drones 
>To register a drone, a request formatted as in the example below is sent. Data sent is validated against required constraints and drone is registered when constraints are passed. The API returns a JSON response of all registered drones.
```sh
{
      "serialNumber": "SN00288399IJB",
      "weightLimit": 250,
      "batteryLevel": 65,
      "modelWeight": "MIDDLEWEIGHT",
      "state": "IDLE"
}
```
### Registering/Creating a medication item
#### API Endpoint: http://localhost:8080/api/v1/drones 
>To add a medication item, a request formatted as in the example below is sent. Data sent is validated against required constraints and drone is registered when constraints are passed. The API returns a JSON response of all registered medications.
```sh
{
    "name": "Paracetamol Extra",
    "weight": 10.0,
    "code": "PRC-500_mg",
    "image": "64bytesCodeGenerated_uncGHHj"
}
```
### Loading a drone with medication items
#### API Endpoint: http://localhost:8080/api/v1/dispatch 
>To add a medication item, a request formatted as in the example below is sent. Data sent is validated against required constraints and drone is registered when constraints are passed. The API returns a JSON response of all registered dispatches (Drone id, a list of loaded medication ids, dispatch state and dates created/updated).
```sh
{
    "droneId": "63260fd21f51d31e0858e6fc",
    "medicationIds": [
    "6325e9e394f91a40d9b4719c",
    "63260e521f51d31e0858e6f9"
    ],
    "state": "LOADED",
    "createdAt": "2022-09-27T22:50:11.913286500",
    "updatedAt": ""
}
```
### Checking Loaded Medication Items For A Given Drone
#### API Endpoint: http://localhost:8080/api/v1/drones/{droneId}/medications
* Request Type: GET
>To check loaded medication items for a given drone, the Uri includes a {droneId} parameter indicating a selected drone id. For test purposes, the id should be copied from the list of loaded drones(dispatches) returned from the dispatches GET query at Uri http://127.0.0.1:8080/api/v1/dispatch. The API response is a collection of Medication objects, below is a sample response with 2 medication items loaded.
```sh
[
    {
        "id": "6325e9e394f91a40d9b4719c",
        "name": "Paracetamol Extra",
        "weight": 10.0,
        "code": "PRC-500_mg",
        "image": "64bytesCodeGenerated_uncGHHj"
    },
    {
        "id": "63260e521f51d31e0858e6f9",
        "name": "Blood Tonic",
        "weight": 80.0,
        "code": "FRG-800mg_fe",
        "image": "64bytesCodeGenerated_uncGHHj"
    }
]
```
### Checking Available Drones For Loading
#### API Endpoint: http://localhost:8080/api/v1/drones/loadable
* Request Type: GET
>Endpoint retrieves a collection of drones available for loading. The request criteria are:
> * Drones should be in either IDLE or LOADING state
> * Drone battery level should not be lower than 25%
```sh
[
    {
        "id": "6325e9e394f91a40d9b4719c",
        "name": "Paracetamol Extra",
        "weight": 10.0,
        "code": "PRC-500_mg",
        "image": "64bytesCodeGenerated_uncGHHj"
    },
    {
        "id": "63260e521f51d31e0858e6f9",
        "name": "Blood Tonic",
        "weight": 80.0,
        "code": "FRG-800mg_fe",
        "image": "64bytesCodeGenerated_uncGHHj"
    }
]
```
### Checking Battery Level For A Given Drone
#### API Endpoint: http://localhost:8080/api/v1/drones/{droneId}/battery
* Request Type: GET
>To check battery level for a given drone, the Uri includes a {droneId} parameter indicating a selected drone id. For the purpose of this project, the id should be copied from the list of loaded drones returned from the drones GET query at Uri http://127.0.0.1:8080/api/v1/drones. The API response is a collection of Medication objects, below is a sample response with 2 medication items loaded.
```sh
[
    {
        "id": "6325e9e394f91a40d9b4719c",
        "name": "Paracetamol Extra",
        "weight": 10.0,
        "code": "PRC-500_mg",
        "image": "64bytesCodeGenerated_uncGHHj"
    },
    {
        "id": "63260e521f51d31e0858e6f9",
        "name": "Blood Tonic",
        "weight": 80.0,
        "code": "FRG-800mg_fe",
        "image": "64bytesCodeGenerated_uncGHHj"
    }
]
```
### Retrieve battery event log
#### API Endpoint: http://localhost:8080/api/v1/drones/battery-log
* Request Type: GET
>GET request to retrieve battery level log of scheduled task checking drone battery levels.
<br />For the purpose of this test, 2 scheduled tasks are implemented:
> * Scheduled task to check battery level at regular intervals
> * Task to alter drone battery levels at intervals.
> The second task is to highlight variations in battery levels changes in the log.
```sh
[
    {
        "id": "6325e9e394f91a40d9b4719c",
        "name": "Paracetamol Extra",
        "weight": 10.0,
        "code": "PRC-500_mg",
        "image": "64bytesCodeGenerated_uncGHHj"
    },
    {
        "id": "63260e521f51d31e0858e6f9",
        "name": "Blood Tonic",
        "weight": 80.0,
        "code": "FRG-800mg_fe",
        "image": "64bytesCodeGenerated_uncGHHj"
    }
]
```



<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

- [x] Add Changelog
- [x] Add back to top links
- [ ] Add Additional Templates w/ Examples
- [ ] Add "components" document to easily copy & paste sections of the readme
- [ ] Multi-language Support
    - [ ] Chinese
    - [ ] Spanish

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - [@iamuthybaba](https://twitter.com/iamuthybaba) - uthmanb@outlook.com

Project Link: [https://github.com/dapperGeek/Spring-Boot-API-Drone-Service-](https://github.com/dapperGeek/Spring-Boot-API-Drone-Service-)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png

[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/

[Spring-boot]:https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
[Spring-boot-url]: https://spring.io/projects/spring-boot
[Java]:https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://java.com
[Mongo-db]:https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white
[Mongo-db-url]: https://mongodb.com
[Docker]:https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://docker.com
[Postman]:https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white
[Postman-url]: https://postman.com

[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
