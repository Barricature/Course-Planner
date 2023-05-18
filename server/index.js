import express from 'express';
import logger from 'morgan'
import cors from 'cors';

const app = express();
const port = process.env.PORT || 3000;
app.use(logger('dev'));
app.use('/', express.static('client'));

const corsOptions ={
   origin:'*', 
   credentials:true,            //access-control-allow-credentials:true
   optionSuccessStatus:200,
}

app.use(cors(corsOptions));

/***************************************** Routes *******************************************/

app.all('*', async (request, response) => {
    response.status(404).send(`Not found: ${request.path}`);
});

app.listen(port, () => {
    const msg = `Server started on http://localhost:${port}`;
    console.log(msg);
});