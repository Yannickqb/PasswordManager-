import "./App.css";
import Navbar from "./comps/Navbar";
import InputWithIcon from "./comps/addpassword";
import { PasswordList } from "./comps/PasswordList";

import { userName } from "./comps/PasswordList";

function App() {
  return (
    <div id="appContainer">
      <Navbar />
      <div id='contentContainer'>
      <div id='pwListContainer'>
        <h3> Password List </h3>
        <ul>
          <PasswordList />
          <li id="addEntry"> + </li>
        </ul>
      </div>
      <div id='dashboard'>
        <h3> Dashboard </h3>
        <h2> Wellcome { userName }! Your passwords are safe! </h2>
        <p className="instructions"> - to display any password press on the name of it in your password-list. </p>
        <p className="instructions"> - add more passwords to your list by pressing the "+"-button. </p>
        <p className="instructions"> - don't forget to log out! otherwise we'll log you out after 15 minutes. </p>

        <InputWithIcon/>
      </div>
      </div>
    </div>
  );
}

export default App;
