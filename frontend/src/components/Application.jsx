import {
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from 'react-router-dom';
import {
  AddQuestion,
  ErrorPage,
  Home,
  QuestionsComponent
} from 'pages';
import { Layout } from 'components/layout-related';
import '../index.css';

const router = createBrowserRouter(createRoutesFromElements(
  <Route path={'/'} element={<Layout />} errorElement={<ErrorPage />}>
    <Route index element={<Home />} />
    <Route path={'/question/new'} element={<AddQuestion />} />
    <Route path={'questions'} element={<QuestionsComponent />} />
  </Route>
));

const Application = () => {
  return (
    <RouterProvider router={router} />
  );
};

export default Application;
