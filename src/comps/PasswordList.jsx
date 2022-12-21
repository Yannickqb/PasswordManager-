import "./PasswordList.css";
import { useState } from "react";

import { data } from "../data/data";

export const userName = data.userName; 

export function PasswordList() {
  return (
    <>
      {data.siteNames.map((sites) => (
        <li className="listElement">
          <h4 key={sites.id}> {sites.siteName} </h4>
        </li>
      ))}
    </>
  );
}
