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

const useHandleViewCountUpdate = () => {
  const { id } = useParams();

  useEffect(() => {
    const updateViews = async () => {
      try {
        await fetch(`/questions/increase-view-count/${id}`, { method: 'PATCH' });
      } catch (error) {
        console.log(error);
      }
    };

    updateViews();
  }, []);
};

export {
  useHandleQuestionDetailsLoader,
  useHandleViewCountUpdate,
};
