import { Outlet } from 'react-router-dom';
import {
  Footer,
  Navbar
} from 'components/layout-related/index';
import './Layout.css';

const Layout = () => {
  return (
    <>
      <Navbar />
      <Outlet />
      <div className={'content-wrap'}></div>
      <Footer />
    </>
  );
};

export default Layout;
