import {
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from 'react-router-dom';
import {
  AddQuestionPage,
  ErrorPagePage,
  HomePage,
  QuestionsPage,
  IndividualQuestionPage,
} from 'pages';
import { Layout } from 'components/layout-related';
import '../index.css';

const router = createBrowserRouter(createRoutesFromElements(
  <Route path={'/'} element={<Layout />} errorElement={<ErrorPagePage />}>
    <Route index element={<HomePage />} />
    <Route path={'/question/new'} element={<AddQuestionPage />} />
    <Route path={'questions'}>
      <Route index element={<QuestionsPage />} />
      <Route path={'id/:id'} element={<IndividualQuestionPage />} />
    </Route>
  </Route>
));

const Application = () => {
  return (
    <RouterProvider router={router} />
  );
};

export default Application;
