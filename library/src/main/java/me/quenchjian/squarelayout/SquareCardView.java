package me.quenchjian.squarelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class SquareCardView extends CardView {

  private SquareMode squareMode;

  public SquareCardView(@NonNull Context context) {
    this(context, null);
  }

  public SquareCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, androidx.cardview.R.attr.cardViewStyle);
  }

  public SquareCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    if (attrs == null) return;
    TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SquareCardView, defStyleAttr, 0);
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
