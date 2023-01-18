import { data } from "../data/data";

export const userName = data.userName;

export function D_home() {
  return (
    <>
      <h2> Wellcome {userName}! Your passwords are safe! </h2>
      <p className="instructions">
        {" "}
        - to display any password press on the entry name in your password-list.{" "}
      </p>
      <p className="instructions">
        {" "}
        - add more entries to your list by pressing the "+"-button.{" "}
      </p>
      <p className="instructions"> - dont forget to log out!</p>
    </>
  );
}


