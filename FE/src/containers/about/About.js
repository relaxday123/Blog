import React from 'react';
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import background from "../../image/2.jpg";
import './style.css';
import gif from "../../image/gif/200w.gif";

function About() {
    return(
        <div>
            <Header image={background} title="About Me" description="This is what I do." />
            <div class="about-main-content">
                <img src={gif} alt='gif' class="about-gif"></img>
                <p>
                Hello friends! I am Nguyen Hoang Anh. I'm a 3rd year student majoring in Computer Engineering, UET, Vietnam National University, Hanoi. My hobbies are reading books and exploring new things
                </p>
            </div>
            <Footer />
        </div>
    )
}

export default About;