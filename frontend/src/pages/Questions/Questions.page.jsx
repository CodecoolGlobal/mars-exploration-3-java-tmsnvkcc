import { PageTitle } from 'components/general';
import { Questions } from 'components/questions-page';
import { useHandleQuestionsFetch } from './Questions.hooks';
import './Questions.styles.css';

const QuestionsPage = () => {
  const { data, loading } = useHandleQuestionsFetch();

  if (loading || data === null) {
    return (
      <div>Loading data...</div>
    );
  }

  return (
    <>
      <PageTitle title={'Questions'} />
      <Questions data={data} />
    </>
  );
};

export default QuestionsPage;
