import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import axios from "axios";
import { Link } from "react-router-dom";

const baseURL = "http://localhost:8080/smartMuseum/artists"

export default function Artist() {

  const [artistData, setArtistData] = React.useState(null);

  React.useEffect(() => {
    async function fetchData() {
        const resp = await axios.get(baseURL);
        setArtistData(resp.data);
    }
    fetchData();
  },[])

  return (
    <div style={{
      display: 'flex', 
      justifyContent: 'space-around',
      marginTop: '20px', 
      alignItems: 'center',
      flexWrap: 'wrap'
    }}>
      {artistData && artistData.map((artist, index) => (
        <Link 
          to={`/artists/${artist && artist['artistID']}`}
          style={{
            textDecoration: 'None'
          }}
        >
          <Card sx={{ maxWidth: 345, marginTop: '20px' }}>
            <CardActionArea>
              <CardMedia
                component="img"
                height="300"
                image={artist && artist['imageUrl']}
                alt="green iguana"
              />
              <CardContent>
                
                  <Typography gutterBottom variant="h6" component="div">
                    {artist && artist['artistName']}
                  </Typography>
                
                {/* <Typography gutterBottom variant="h5" component="div">
                    {artwork && artwork['title']}
                  </Typography> */}
              </CardContent>
            </CardActionArea>
          </Card>
        </Link>
      ))}
    </div>
  );
}