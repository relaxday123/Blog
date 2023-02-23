import instance from './axiosInstance';

const login = (endPoint, data) => {
  return instance.post(endPoint, data);
};

const httpClient = {
  login
};

export default httpClient;
