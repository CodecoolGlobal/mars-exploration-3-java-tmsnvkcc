<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/CodecoolGlobal/mars-exploration-3-java-tmsnvkcc">
    <img src="frontend/src/images/question-answer-line.svg" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Stack-n-Snack</h3>

  <p align="center">
    A full-stack web application inspired by the popular Q&A platform, Stack Overflow. This project is built with Spring Boot for the backend and React for the frontend, offering an interactive user experience.
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
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#authors">Authors</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![Product Screen Shot][product-screenshot]
*temporary screenshot*

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* ![Spring Boot][Spring Boot]
* ![PostgreSQL][PostgreSQL]
* ![React][React]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started
> It is important to note, that the installation could be a little bit longer, and contains more steps since the project is not dockerized yet.

### Prerequisites

* **Database**:
    Install [pgAdmin](https://www.pgadmin.org/) on the following link: https://www.pgadmin.org/download/

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/CodecoolGlobal/mars-exploration-3-java-tmsnvkcc.git
   ```
2. Create a new database in pgAdmin

3. Fill in the following environment variables
    - Hostname (DB_HOST)
    - Port (DB_PORT)
    - Database name (DB_NAME)
    - Your postgres "user" which is `postgres` by default (DB_USERNAME)
    - postgres "user's" password (DB_PASSWORD)

4. Run the database initialization code in pgAdmin using Query tool. You can find it here: `backend/src/main/resources/stack_n_snack.sql`. This code will create the necessary tables and provide a few dummy data.

5. Install NPM packages
    ```sh
    cd .\frontend\
    npm install
    ```

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



<!-- AUTHORS -->
## Authors

<a href="https://github.com/CodecoolGlobal/mars-exploration-3-java-tmsnvkcc/graphs/contributors">
 <img src="https://contrib.rocks/image?repo=CodecoolGlobal/mars-exploration-3-java-tmsnvkcc" />
</a>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[product-screenshot]: frontend/src/images/temporary-screenshot.png
[Spring Boot]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=Spring&logoColor=FFFFFF
[PostgreSQL]: https://img.shields.io/badge/PostgreSQL-FFFFFF?style=for-the-badge&logo=PostgreSQL&logoColor=0064a5
[React]: https://img.shields.io/badge/React-000000?style=for-the-badge&logo=React&logoColor=7cc5d9
