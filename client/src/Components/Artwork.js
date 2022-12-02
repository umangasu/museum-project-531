import PropTypes from 'prop-types'
// import React, { Component } from 'react'
import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import axios from "axios";
import { Link } from "react-router-dom";

const baseURL = "http://localhost:8080/smartMuseum/artworks"

export default function Artwork() {

  const [artworkData, setArtworkData] = React.useState(null);

  React.useEffect(() => {
      axios.get(baseURL).then((response) => {
          console.log('before setting artwork data to json', response.data);
          setArtworkData(response.data);
          console.log('after setting artwork data to json', artworkData);
      })
  }, [artworkData])

  return (
    <div style={{
      display: 'flex', 
      justifyContent: 'space-around',
      marginTop: '20px', 
      alignItems: 'center',
      flexWrap: 'wrap'
    }}>
      {artworkData && artworkData.map((artwork, index) => (
          <Card sx={{ maxWidth: 345 }}>
            <CardActionArea>
              <CardMedia
                component="img"
                height="140"
                image={artwork && artwork['imageUrl']}
                alt="green iguana"
              />
              <CardContent>
                <Link to={`/artworks/${artwork && artwork['artworkID']}`}>
                  <Typography gutterBottom variant="h5" component="div">
                    {artwork && artwork['title']}
                  </Typography>
                </Link>
                {/* <Typography gutterBottom variant="h5" component="div">
                    {artwork && artwork['title']}
                  </Typography> */}
              </CardContent>
            </CardActionArea>
          </Card>
      ))}
    </div>
  )
  
}