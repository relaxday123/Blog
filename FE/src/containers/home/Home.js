import React from "react";
import "./style.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import background from "../../image/1.jpg";
import { TypeAnimation } from "react-type-animation";

function Home() {
  return (
    <div>
      <Header
        image={background}
        title="Nguyen Hoang"
        description="Software Engineer"
      />
      <div class="main-content">
        <TypeAnimation
          sequence={[
            "😄 Hi mate !!!! 😄", // Types 'One'
            2000, // Waits 1s
            "Welcome to my blog", // Types 'Three' without deleting 'Two'
            3000, // Waits 2s
            "Feel free to discover anything", // Types 'Three' without deleting 'Two'
            3000, // Waits 2s
            () => {},
          ]}
          wrapper="div"
          cursor={true}
          repeat={Infinity}
          style={{ fontSize: "2em", margin: "0 auto", padding: "50px 0" }}
        />
        <div class="list">
          <div class="post">
            <a>
              <h1 class="title">Manage data in Docker</h1>
              <h2 class="preview">
                How to use volumes and bind mounts in Docker
              </h2>
            </a>
            <p class="more">Poster by Ocean Nguyen on May 20, 2019</p>
          </div>
          <div class="post">
            <a>
              <h1 class="title">Manage data in Docker</h1>
              <h2 class="preview">
                How to use volumes and bind mounts in Docker
              </h2>
            </a>
            <p class="more">Poster by Ocean Nguyen on May 20, 2019</p>
          </div>
        </div>
        <div class="button">
          <button>View all posts</button>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default Home;
