package com.test.ui.user

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import com.test.R

@Composable
fun UserScreen(viewModel: UserViewModel) {
    val user = viewModel.user
    user?.let {
        Column {
            GlideImage(
                user.picture.large,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
            Spacer(Modifier.height(16.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = user.getName(),
                    fontSize = 20.sp,
                    color = colorResource(R.color.text)
                )
                Text(
                    text = user.login.username,
                    color = colorResource(R.color.text)
                )
                Text(
                    text = user.cell,
                    color = colorResource(R.color.text)
                )
                Text(
                    text = user.phone,
                    color = colorResource(R.color.text)
                )
                Text(
                    text = user.email,
                    color = colorResource(R.color.text)
                )
                Text(
                    text = user.gender,
                    color = colorResource(R.color.text)
                )
            }
        }
    }
}