import * as React from 'react';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import WebseiteIcon from '../img/internet.png';
import PasswordIcon from '../img/smart-lock.png';
import UserIcon from '../img/user.png';


export default function InputWithIcon() {
    return (
        <Box sx={{ width: '300px', backgroundColor: '#bebebe', borderStyle: 'solid'}}>
            <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
                <img src={WebseiteIcon} height={30} />
                <TextField id="webseite" label="Webseite" variant="standard" />
            </Box>
            <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
                <img src={UserIcon} height={30} />
                <TextField id="uername" label="Username" variant="standard" />
            </Box>
            <Box sx={{ display: 'flex', alignItems: 'flex-end'}}>
                <img src={PasswordIcon} height={30} />
                <TextField id="password" label="Password" variant="standard" />
            </Box>
            <Stack direction="row" spacing={2}>
      <Button>Safe</Button>
    </Stack>
        </Box>
    );
}