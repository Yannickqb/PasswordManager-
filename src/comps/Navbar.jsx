import './Navbar.css'; 

import { userName } from './PasswordList';

const Emoji = (props) => (
  <span
    className="emoji"
    role="img"
    aria-label={props.label ? props.label : ""}
    aria-hidden={props.label ? "false" : "true"}
  >
    {props.symbol}
  </span>
);

export function Navbar(){ 
    return(
        <div id='navContainer'>
            <div id='titleContainer'>
                <h1> Password Safe <Emoji symbol="🏛️" /> </h1>
                <span id='loggedInAs'> Logged in as: </span> 
                <span> { userName } </span>
            </div>
                <button id="logOut"> Log Out </button>
        </div>
    );
}
