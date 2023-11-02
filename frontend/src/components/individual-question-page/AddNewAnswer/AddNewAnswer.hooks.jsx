import { serialiseFormData } from 'utilities';

const useHandleNewAnswerSubmission = () => {
  const submitAnswer = async (event) => {
    event.preventDefault();

    try {
      const payload = serialiseFormData(event.target);
      await fetch('/questions/add-new-answer', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        body: JSON.stringify(payload),
      });

      window.location.reload();
    } catch (error) {
      console.log(error);
    }
  };

  return {
    submitAnswer,
  };
};

export {
  useHandleNewAnswerSubmission,
};
