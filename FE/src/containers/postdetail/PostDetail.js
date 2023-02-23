import React, { useEffect, useState, useParams } from 'react';
import axios from "axios";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import background from "../../image/3.png";
import Posts from"../post/Post";
import { Link } from "react-router-dom";

function PostDetail({posts}) {
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    console.log("posts = ", posts);
    if (loading) {
        return <div>
            <Header image={background} title="Posts" description="" />
            <div>
                Loading
            </div>
            <Footer />
        </div>
    };

    return (
        <div>
            <Header image={background} title="Posts" description="" />
            <div class="main-content">
            </div>
            <Footer />
        </div>
    );
}

export default PostDetail;