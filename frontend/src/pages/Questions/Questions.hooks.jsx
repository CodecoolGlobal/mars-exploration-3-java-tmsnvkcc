import {useEffect, useState} from "react";

const useHandleQuestionsFetch = () => {
  const [loading, setLoading] = useState(true);
  const [data, setData] = useState(null);

  useEffect(() => {
    const getQuestions = async () => {
      try {
        const response = await fetch('/questions/all', {
          method: 'GET'
        });

        const data = await response.json();
        setData(data);
      } catch (error) {
        console.log(error);
      } finally {
        setLoading(false);
      }
    }

    getQuestions();
  }, []);

  return {
    data,
    loading
  };
};

export {
  useHandleQuestionsFetch
};
