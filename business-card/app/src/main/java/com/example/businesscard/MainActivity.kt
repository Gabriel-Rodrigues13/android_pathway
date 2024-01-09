package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ApresentationCardApp()
                }
            }
        }
    }
}

@Composable
fun ApresentationCardApp() {

    ApresentationCard(
        fullName = stringResource(R.string.fullName),
        title = stringResource(R.string.tittle),
        fontColor = Color(67,147,75),
        backGroundColor = Color(157, 235, 171)
    )
    ContactInformation(
        cellphoneNumber = stringResource(R.string.cellphoneNumber),
        socialMedia = stringResource(R.string.socialMedia),
        email = stringResource(R.string.email),
        fontColor = Color(67,147,75)
    )
}

@Composable
fun ApresentationCard(
    fullName: String,
    title: String,
    fontColor: Color,
    backGroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(backGroundColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = stringResource(R.string.descriptionLogo),
            modifier = modifier
                .size(150.dp)
                .background(color = Color(7, 48, 66))
        )
        Text(
            text = fullName,
            fontSize = 32.sp
        )
        Text(
            text = title,
            color = fontColor,
            fontSize = 28.sp
        )
    }
}

@Composable
fun ContactInformation(
    cellphoneNumber: String,
    socialMedia: String,
    fontColor: Color,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_call_24),
                contentDescription = stringResource(R.string.descriptionPhoneNumber),
                tint = fontColor
            )
            Text(
                text = cellphoneNumber,
                modifier.padding(start = 4.dp, bottom = 4.dp),
                color = fontColor
            )
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_share_24),
                contentDescription = stringResource(R.string.descriptionShare),
                tint = fontColor )
            Text(
                text = socialMedia,
                modifier = modifier.padding(start = 4.dp ,bottom = 4.dp),
                color = fontColor
            )
        }
        Row {
        Icon(
            painter = painterResource(id = R.drawable.baseline_email_24),
            contentDescription = stringResource(R.string.descriptionEmail),
            tint = fontColor
        )
        Text(
            text = email,
            modifier = modifier.padding(start = 4.dp, bottom = 16.dp ),
            color = fontColor
        )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ApresentationCardPreview() {
    BusinessCardTheme {
        ApresentationCardApp()
    }
}