import "./Navbar.css";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/" className="list">
            Home
          </Link>
        </li>
        <li>
          <Link to="/question" className="list">
            Questions
          </Link>
        </li>
        <li>
          <Link to="/question/new" className="list">
            Ask a question!
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
