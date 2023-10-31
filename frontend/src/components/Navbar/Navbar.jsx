// import React from "react";
import "./Navbar.css";
import {Link} from "react-router-dom";

const Navbar = () => {

    return (
        <nav>
            <ul>
                <li>
                    <Link to="/" class="list">
                        Home
                    </Link>
                </li>
                <li>
                    <Link to="/question" class="list">
                        Questions
                    </Link>
                </li>
                <li>
                    <Link to="/question/new" class="list">
                        Ask a question!
                    </Link>
                </li>
            </ul>
        </nav>
    );
};

export default Navbar;
