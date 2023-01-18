import { useState } from "react";
import "./App.css";
import { Navbar } from "./comps/Navbar";
import { D_home } from "./comps/PasswordList";
//import { PasswordList } from "./comps/PasswordList";
//import { InputWithIcon } from "./comps/addpassword";

import { data } from "./data/data";


function App() {
  const [siteName, setSiteName] = useState("Select");
  const [select, setSelect] = useState(false);

  const clickHandle = (e) => {
    setSelect(true);
    setSiteName(e);
  };

  function PasswordList() {
    return (
      <>
        {data.siteNames.map((sites) => (
          <li
            className="listElement"
            key={sites.id}
            onClick={() => clickHandle(sites.siteName)}
          >
            <h4> {sites.siteName} </h4>
          </li>
        ))}
      </>
    );
  }
  const D_entry = () => {
    return (
      <div id="entryContainer">
        <h2> {siteName} </h2>
        <p> username:  {}  </p>
        <p> password: {} </p>
      </div>
    );
  }

  return (
    <div id="appContainer">
      <Navbar />
      <div id="contentContainer">
        <div id="pwListContainer">
          <h3> Password List </h3>
          <ul>
            <PasswordList />
            <li id="addEntry"> + </li>
          </ul>
        </div>
        <div id="dashboard">
          <h3> Dashboard </h3>
          {
            select ? (
              <D_entry siteName={siteName} />    
            ):(
              <D_home/>
            )
          }
          
        </div>
      </div>
    </div>
  );
}

export default App;
