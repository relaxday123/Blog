import React, { useState } from "react";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import background from "../../image/5.jpg";
import "./style.css";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import "bootstrap/dist/css/bootstrap.min.css";
import {
  validateEmail,
  validatePassword,
} from "../../shared/helpers/validate/validate";
import axios from "axios";
import { Navigate } from "react-router-dom";
import { useNavigate } from 'react-router-dom';

function Login() {
    const navigate = useNavigate();
  // API login
  // nhan ve token
  localStorage.setItem("token", "22222222");
  const [values, setValues] = useState({
    email: "",
    password: "",
  });

  // const { setToken, setUserId } = useContext(UserContext)

  const [touched, setTouched] = useState({
    email: false,
    password: false,
  });

  const errorEmail = validateEmail(values.email);

  const errorPassword = validatePassword(values.password);

  const handleChange = (evt) => {
    console.log("evt = ", evt);
    setValues({
      ...values,
      [evt.target.name]: evt.target.value,
    });
  };

  const handleBlur = (evt) => {
    setTouched({
      ...touched,
      [evt.target.name]: true,
    });
  };

  const formValid = !errorEmail && !errorPassword;

  const handleSubmit = (event) => {
    axios
      .post("localhost:8080/login/", { values })
      .then(Navigate("http://localhost:3000/"))
      .catch(console.log("wrong user"));
  };

  const onFinish = async () => {
    try {
      navigate('/');
    } catch (error) {
      if (error) {
        console.log('Username or password is incorrect. Please try again');
      }
    }
  };

  return (
    <div>
      <Header
        image={background}
        title="Ocean Nguyen"
        description="Engineer/Video Creator"
      />
      <div className="login-form">
        <Form
          validated={false}
          onSubmit={() => {
            let values = {
              email: values.email,
              password: values.password,
            };
            onFinish();
          }}
        >
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control
              name="email"
              value={values.email}
              onChange={handleChange}
              onBlur={handleBlur}
              type="email"
              placeholder="Enter email"
              required
              isInvalid={touched.email && Boolean(errorEmail)}
              isValid={touched.email && !Boolean(errorEmail)}
            />
            <Form.Control.Feedback type="invalid">
              {errorEmail}
            </Form.Control.Feedback>
            <Form.Control.Feedback type="valid">
              Looks good!
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control
              name="password"
              value={values.password}
              onChange={handleChange}
              onBlur={handleBlur}
              type="password"
              placeholder="Password"
              isInvalid={touched.password && Boolean(errorPassword)}
              isValid={touched.password && !Boolean(errorPassword)}
            />
            <Form.Control.Feedback type="invalid">
              Password must have more than 8 characters.
            </Form.Control.Feedback>
            <Form.Control.Feedback type="valid">
              Looks good!
            </Form.Control.Feedback>
          </Form.Group>
          <Button disabled={!formValid} variant="primary" type="submit">
            Submit
          </Button>
        </Form>
      </div>
      <Footer />
    </div>
  );
}

export default Login;
