import PropTypes from 'prop-types'
// import React, { Component } from 'react'
import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';

export default function ExhibitionDetail() {

  return (
    <div style={{
      display: 'flex', 
      justifyContent: 'space-around',
      marginTop: '20px', 
      alignItems: 'center',
      flexWrap: 'wrap'
    }}>
      <Card sx={{ maxWidth: 345 }}>
        <CardActionArea>
          <CardMedia
            component="img"
            height="140"
            image="/static/images/cards/contemplative-reptile.jpg"
            alt="green iguana"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              Artwork 1
            </Typography>
            <Typography variant="body2" color="text.secondary">
              First artwork descriptions
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
      <Card sx={{ maxWidth: 345 }}>
        <CardActionArea>
          <CardMedia
            component="img"
            height="140"
            image="/static/images/cards/contemplative-reptile.jpg"
            alt="green iguana"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              Artwork 2
            </Typography>
            <Typography variant="body2" color="text.secondary">
              First artwork descriptions
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
      <Card sx={{ maxWidth: 345 }}>
        <CardActionArea>
          <CardMedia
            component="img"
            height="140"
            image="/static/images/cards/contemplative-reptile.jpg"
            alt="green iguana"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              Artwork 3
            </Typography>
            <Typography variant="body2" color="text.secondary">
              First artwork descriptions
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
    </div>
  )
  
}