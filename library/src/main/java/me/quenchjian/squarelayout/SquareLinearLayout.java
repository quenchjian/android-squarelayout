package me.quenchjian.squarelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class SquareLinearLayout extends LinearLayout {

  private SquareMode squareMode;

  public SquareLinearLayout(Context context) {
    this(context, null);
  }

  public SquareLinearLayout(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SquareLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  public SquareLinearLayout(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {
    if (attrs == null) return;
    TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SquareLinearLayout, defStyleAttr, 0);
    squareMode = SquareMode.fromId(array.getInt(R.styleable.SquareCardView_squareMode, SquareMode.FOLLOW_WIDTH.id));
    array.recycle();
  }

  @SuppressWarnings("SuspiciousNameCombination")
  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    ViewGroup.LayoutParams lp = getLayoutParams();
    if (squareMode == SquareMode.FOLLOW_WIDTH && lp.width > 0) {
      super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    } else if (squareMode == SquareMode.FOLLOW_HEIGHT && lp.height > 0) {
      super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    } else {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
  }
}
