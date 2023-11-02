import { useParams } from 'react-router-dom';
import {
  useEffect,
  useState,
} from 'react';

const useHandleQuestionDetailsLoader = () => {
  const [loading, setLoading] = useState(true);
  const [data, setData] = useState(null);
  const { id } = useParams();

  useEffect(() => {
    const questionDetailsLoader = async () => {
      try {
        console.log(id);
        const response = await fetch(`/questions/${id}`, {
          method: 'GET',
        });

        const data = await response.json();

        setData(data);
      } catch (error) {
        console.error(error);
      } finally {
        setLoading(false);
      }
    };

    questionDetailsLoader();
  }, []);

  return {
    loading,
    data,
  };
};

export default useHandleQuestionDetailsLoader;
