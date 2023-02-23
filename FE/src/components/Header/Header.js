import './style.css';
import React from 'react';
import { BrowserRouter as Layout, Link, Router, Route, Routes, Switch, } from 'react-router-dom';
import logo from '../../image/logo.png';

function Header({ image, title, description }) {
    return (
        <div>
            <div class="black">
                <img className="banner" src={image} alt="" />
            </div>
            <div class="content">
                <h1>{title}</h1>
                <p>{description}</p>
            </div>
        </div>
    );
}

export default Header;