import './PageTitle.style.css';

const PageTitle = ({ title }) => {
  return (
    <section>
      <h1 className={'page-title'}>{title}</h1>
    </section>
  );
};

export default PageTitle;
