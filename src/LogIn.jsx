import "./LogIn.css";

export function LogIn() {
    function checkLogIn(){
        console.log("nice!"); 
    }
  return (
    <div id="screen">
      <div id="loginContainer">
        <h2> LogIn </h2>
        <div id="inputArea">
          <label for="username">
            <p> username: </p>
          </label>
          <input id="username"></input>
          <br />
          <label for="password">
            <p> password: </p>
          </label>
          <input id="password" type="password"></input>
        </div>
        <br></br>
        <button id="logIn" onClick={checkLogIn}> Log In </button>
        <p id="dontOwnAcc">
          {" "}
          Dont own an account yet? Create account <a href=""> here</a>.{" "}
        </p>
      </div>
    </div>
  );
}
