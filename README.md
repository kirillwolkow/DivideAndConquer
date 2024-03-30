<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<div>
<h3 align="center">Divide and Conquer Algorithms</h3>

  <p align="center">
    Measurements of different DnC algorithms with various implementations.
    <br />
    <a href="https://github.com/kirillwolkow/DivideAndConquer/documentation/OBSERVATIONS.md"><strong>Explore the observations</strong></a>
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## About The Project

As part of a task for the module Algorithms & Datastructures at Bern University of Applied Sciences, we should create a sub-interface of a DnC design pattern.

Furthermore, the following tasks should be completed:
- dynamic-programming DnC method with an additional memory function parameter (caching) of your choice
- concurrent/multithreaded/parallelised DnC method by using a thread pool and switching to sequential processing when the pool capacity is reached (to avoid deadlocks!)
- Implement all three interfaces in (wrapper) classes to calculate the Fibonacci numbers
- Compare the performance (execution times) of all your implementing classes graphically (JavaFX: class Chart extends Application) and explain your observations

Go to [OBSERVATIONS.md](https://github.com/kirillwolkow/DivideAndConquer/documentation/OBSERVATIONS.md) for the report.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

* Maven [Installation Guide](https://maven.apache.org/install.html)
* JavaFX [Installation Guide](https://openjfx.io/openjfx-docs/#maven)

### Installation & Usage

1. Clone the repo
   ```sh
   git clone https://github.com/kirillwolkow/DivideAndConquer.git
   ```
2. Run Maven Build
   ```sh
   mvn clean install
   ```
3. Start JavaFX with Maven
   ```sh
   mvn javafx:run
   ```

Alternatively, JavaFX can also run via a RunConfiguration. The following VM options must be set up for this.
PATH_TO_FX should point to the lib folder of your javafx module.
```sh
--module-path
${PATH_TO_FX}
--add-modules
javafx.fxml,javafx.controls,javafx.graphics
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Kenny Wolf - mail@kennywolf.dev

Project Link: [https://github.com/kirillwolkow/DivideAndConquer](https://github.com/kirillwolkow/DivideAndConquer)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/kirillwolkow/DivideAndConquer/blob/main/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/kennywolf-dev
[product-screenshot]: images/screenshot.png
