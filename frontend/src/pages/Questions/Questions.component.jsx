import { PageTitle } from 'components/general';
import { useHandleQuestionsFetch } from './Questions.hooks';
import './Questions.styles.css';

const QuestionsComponent = () => {
  const { data, loading } = useHandleQuestionsFetch();

  if (loading) {
    return (
      <div>Loading data...</div>
    );
  }

  return (
    <div>
      <PageTitle title={'Questions'} />
      {data.map((question) => {
        return (
          <div key={question.id}>
            <h1>{question.title}</h1>
            <p>{question.description}</p>
            <p>{question.createdAt}</p>
          </div>
        );
      })}
    </div>
  );
};

export default QuestionsComponent;
