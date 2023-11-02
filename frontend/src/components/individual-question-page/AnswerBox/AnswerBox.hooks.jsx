import {
  useEffect,
  useState
} from "react";

const useHandleLikeCountUpdate = (answerId) => {
  const [likeCount, setLikeCount] = useState(0);
  const [disLikeCount, setDislikeCount] = useState(0);
  const [toggle, setToggle] = useState(false);

  const updateLikeCount = async () => {
    try {
      await fetch(`/questions/update-likes/${answerId}`, {
        method: 'PATCH'
      });
      setToggle(!toggle);
    } catch (error) {
      console.log(error);
    }
  };

  const updateDislikeCount = async () => {
    try {
      await fetch(`/questions/update-dislikes/${answerId}`, {
        method: 'PATCH'
      });
      setToggle(!toggle);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    const getPopularityCounts = async () => {
      try {
        const response = await fetch(`/questions/popularity-count/${answerId}`, {
          method: 'GET'
        });
        const data = await response.json();
        setLikeCount(data.numberOfLikes);
        setDislikeCount(data.numberOfDislikes);
      } catch (error) {
        console.log(error);
      }
    };

    getPopularityCounts();
  }, [toggle]);

  return {
    likeCount,
    disLikeCount,
    updateLikeCount,
    updateDislikeCount
  };
};

export {
  useHandleLikeCountUpdate,
}
