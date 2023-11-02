import './AddQuestion.css';
import { useNavigate } from 'react-router-dom';
import { PageTitle } from 'components/general';
import NewQuestionForm from 'components/question-adding-page/NewQuestionForm';

const AddQuestionPage = () => {
  const navigate = useNavigate();

  const handleCreate = async (question) => {
    await fetch('/questions/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(question),
    });
    navigate('/questions');
  };

  return (
    <div>
      <PageTitle title={'Add a new question!'} />
      <NewQuestionForm onSave={handleCreate} />
    </div>
  );
};

export default AddQuestionPage;
