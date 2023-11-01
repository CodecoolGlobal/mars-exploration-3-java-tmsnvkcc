import { Outlet } from 'react-router-dom';
import { Navbar } from "components/index";
import './Layout.css';

const Layout = () => {
  return (
    <>
      <Navbar />
      <Outlet />
      <footer>
        Placeholder footer.
      </footer>
    </>
  );
};

export default Layout;
