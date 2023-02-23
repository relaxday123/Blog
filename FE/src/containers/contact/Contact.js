import React, { useState } from "react";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import background from "../../image/4.jpg";
import "./style.css";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import {
  validateEmail,
  validatePassword,
} from "../../shared/helpers/validate/validate";

function Contact() {
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
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }
  };

  return (
    <div>
      <Header
        image={background}
        title="Contact Me"
        description="Have questions? I have answers."
      />
      <div class="main-content">
        <p>
          Want to get in touch? Fill out the form below to send me a message and
          I will get back to you as soon as possible!
        </p>
      </div>
      <div className="info-form">
        <Form noValidate validated={false} onSubmit={handleSubmit}>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control
              type="email"
              placeholder="Enter email"
              name="email"
              value={values.email}
              onChange={handleChange}
              onBlur={handleBlur}
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
            <Form.Text className="text-muted">
              We'll never share your email with anyone else.
            </Form.Text>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control
              type="password"
              placeholder="Password"
              name="password"
              value={values.password}
              onChange={handleChange}
              onBlur={handleBlur}
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
          <Form.Group className="mb-3" controlId="formBasicCheckbox">
            <Form.Check type="checkbox" label="Check me out" />
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

export default Contact;
