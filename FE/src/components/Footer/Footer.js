import React from "react";
import "./style.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { library } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import {
    solid,
    regular,
    brands,
    icon,
} from "@fortawesome/fontawesome-svg-core/import.macro"; // <-- import styles to be used
import { faFacebook, faLinkedin, faGithub } from "@fortawesome/free-brands-svg-icons";

function Footer() {
    const list = [
        {
            itemName: faFacebook,
            href: "https://www.facebook.com/profile.php?id=100005947028516",
        },
        {
            itemName: faLinkedin,
            href: "https://www.linkedin.com/in/nguy%E1%BB%85n-ho%C3%A0ng-anh-426182140/",
        },
        {
            itemName: faGithub,
            href: "https://github.com/relaxday123",
        },
    ];

    return (
        <div class="footer">
            <div className="list-icon">
                {list.map((item, index) => (
                    <div className="icon" key={index}>
                        <a href={item.href} target="_blank" rel="noreferrer">
                            <FontAwesomeIcon icon={item.itemName} />
                        </a>
                    </div>
                ))}
            </div>
            <div class="text">Copyright © Nguyen Hoang 2022</div>
        </div>
    );
}

export default Footer;
