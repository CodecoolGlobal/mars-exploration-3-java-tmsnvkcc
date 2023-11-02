import './NewQuestionForm.styles.css';
import { useState } from 'react';

const NewQuestionForm = ({ question, onSave }) => {
  const [title, setTitle] = useState(question?.title ?? '');
  const [description, setDescription] = useState(question?.title ?? '');

  const handleSubmit = (e) => {
    e.preventDefault();

    onSave({
      title,
      description,
    });
  };

  return (
    <form onSubmit={handleSubmit} className={'new-question-form'}>
      <label htmlFor={'q-title'}>Question title:</label>
      <input id={'q-title'} value={title} onChange={(e) => setTitle(e.target.value)} />

      <label htmlFor={'q-desc'}>Description:</label>
      <textarea id={'q-desc'} value={description} onChange={(e) => setDescription(e.target.value)} />

      {/*<hr/>*/}
      <button type={'submit'}>Ask!</button>
    </form>
  );
};

export default NewQuestionForm;
