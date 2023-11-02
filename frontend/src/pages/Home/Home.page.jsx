import './Home.css';
import Chooser from '../../components/general/Chooser';
import PageTitle from '../../components/general/PageTitle';

const HomePage = () => {

  return (
    <div className={'home-page-full'}>
      <PageTitle title={'Home'}/>

      <p>
        <strong>Welcome to our website</strong>, a platform designed to engage and empower you with the knowledge and insights you seek.
        <br/>Our mission is to create a space where you can ask questions, share ideas, and learn from diverse perspectives.
        <br/>We believe that knowledge is a journey, not a destination, and we are here to guide you on that journey neuraltext.com.
      </p>

      <hr/>

      <Chooser />

      <hr/>

      <p>
        <strong>We strive</strong> to make our website a reflection of our personality.
        <br/>Our design is clean, minimalist, and user-friendly, just like our approach to information dissemination.
        <br/>We use distinctive design techniques to draw your attention, leveraging surrounding visuals and typography techniques to enhance the attractiveness of our introductory text webfx.com.
      </p>

      <hr/>

      <p>
        Our website is <strong>more</strong> than just a collection of pages.
        <br/>It is a community where you can ask questions, share your thoughts, and engage in meaningful discussions.
        <br/>We have a variety of topics to choose from, ranging from technology and science to literature and arts.
        <br/>Whether you are a student, a professional, or just someone who loves to learn, you will find something that interests you here neuraltext.com.
      </p>

    </div>
  );
};

export default HomePage;
