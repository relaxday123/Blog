import axios from "axios";
import React, { useEffect, useState } from "react";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import background from "../../image/3.png";
import notFound from "../../image/notFound.jfif";
import "./style.css";
import {
  BrowserRouter as Layout,
  Link,
  Router,
  Route,
  Routes,
  Switch,
} from "react-router-dom";
import PostDetail from "../postdetail/PostDetail";
import apiClient from "../../httpClient/axiosInstance";

function Post() {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    let didCancel = false;

    // axios.get("https://newsapi.org/v2/everything?q=Docker&pageSize=10&apiKey=0a57eee23885470e841dd9cac9897f61")
    //     .then(response => {
    //         if (!didCancel) {
    //             setLoading(false);
    //             setPosts(response.data.articles);
    //         }
    //     })
    //     .catch(() => {
    //         if (!didCancel) {
    //             setLoading(false);
    //             setError("Error")
    //         }
    //     })

    async function fetchData() {
      // You can await here
      const res = await apiClient
        .get("/post/", {
          headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
          },
        })
        .then((response) => {
          if (!didCancel) {
            setLoading(false);
            setPosts(response.data);
          }
        })
        .catch(() => {
          if (!didCancel) {
            setLoading(false);
            setError("Error");
          }
        });
      // ...
    }
    fetchData();

    return () => {
      didCancel = true;
    };
  }, []);

  const viewAllPosts = () => {};

  // console.log("posts = ", posts);
  if (loading) {
    return (
      <div>
        <Header image={background} title="Posts" description="" />
        <div>Loading</div>
        <Footer />
      </div>
    );
  }

  return (
    <>
      <Header image={background} title="Posts" description="" />
      <div class="main-content">
        <div class="list">
          <ul>
            {posts.map((post) => (

            // Testing api from internet
            //   <li class="post" key={post.url}>
            //     <a class="post-link" href={post.url}>
            //       <img
            //         class="post-image"
            //         src={post.urlToImage}
            //         alt={notFound}
            //       ></img>
            //       <h1 class="title">{post.title}</h1>
            //       <h2 class="preview">{post.description}</h2>
            //     </a>
            //     <p class="more">{post.author}</p>
            //   </li>

              <li class="post" key={post.id}>
              <a class="post-link" href={post.id}>
                {/* <img
                  class="post-image"
                  src={post.urlToImage}
                  alt={notFound}
                ></img> */}
                <h1 class="title">{post.title}</h1>
                <h2 class="preview">{post.description}</h2>
              </a>
              <p class="more">{post.author.firstName} + {post.author.lastName}</p>
            </li>
            ))}
          </ul>
        </div>
        <div class="button">
          <button onClick={viewAllPosts}>View all posts</button>
        </div>
      </div>
      <Footer />
      <Routes>
        <Route path="postdetail" element={<PostDetail />} />
      </Routes>
    </>
  );
}

export default Post;
