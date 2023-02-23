import "./App.css";
import React from "react";
import {
  Link,
  Route,
  Routes,
  Outlet,
} from "react-router-dom";
import { Select } from "antd";
import Home from "./containers/home/Home";
import Login from "./containers/login/Login";
import About from "./containers/about/About";
import Post from "./containers/post/Post";
import PostDetail from "./containers/postdetail/PostDetail";
import Contact from "./containers/contact/Contact";
import NotFound from "./containers/notfound/NotFound";
import logo from "./image/logo.png";

// const LANGUAGES = {
//   EN: "en",
//   VI: "vi",
// };

const { Option } = Select;  

function App() {

  return (
    <div className="header">
      <div class="navbar">
        <div class="left">
          <div class="logo">
            <img src={logo} alt="Logo" />
          </div>
        </div>
        <div class="right">
          <nav class="menu">
            <Link class="tab" to="/">
              HOME
            </Link>
            <Link class="tab" to="about">
              ABOUT
            </Link>
            <Link class="tab" to="post">
              POST
            </Link>
            <Link class="tab" to="contact">
              CONTACT
            </Link>
            <Link class="tab" to="login">
              LOGIN
            </Link>
          </nav>
        </div>
      </div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="about" element={<About />} />
        <Route path="post" element={<Outlet />}>
          <Route index element={<Post />} />
          <Route path=":postId" element={<PostDetail />} />
        </Route>
        <Route path="contact" element={<Contact />} />
        <Route path="login" element={<Login />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </div>
  );
}

export default App;
