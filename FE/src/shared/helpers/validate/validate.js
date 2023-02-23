export const validateEmail = email => {
    if (!email) return "Email is required";
    if (!String(email)
      .toLowerCase()
      .match(
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      )) {
      return "Email is invalid"
    }
    return ""
  };
  
  export const validatePassword = password => {
    if(!password) return "Password is required";
    if(password.length < 8) return "At least 8 characters";
    return ""
  }
  